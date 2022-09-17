package com.indsys.SpringBootBackEnd.v2.costingNew.repositories;

import com.indsys.SpringBootBackEnd.v2.costingNew.models.CommonDetailsCosting;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonDetailsCostingRepository extends MongoRepository<CommonDetailsCosting, String> {

    @Query(value = "{'totalDetailsId':?0}")
    CommonDetailsCosting getByTotalDetailsId(String totalDetailsId);

    @Query(value = "{'status': ?0}")
    List<CommonDetailsCosting> getByStatus(int status);

    @Query(value = "{$or: [{'status': ?0}, {'status': ?1}]}")
    List<CommonDetailsCosting> getByStatuses(int status1, int status2);

    /*
        For trimTypes Woven and Printed,
        Sample head should not view costing sheets having status approved (ie., 2)

        For trimTypes Tag and Sticker (Including Sub types)
        Sample head can view costing sheets of all states
     */

    /*
        old query eliminating costing sheets having status approved
        @Query(value = "{$and:[{'trimType': { $in: ?0 } },{'status': {$ne: 2} } ]}")
     */
    @Query(value = "" +
            "{" +
                "$and: [" +
                    "{'trimType': { $in: ?0 }}," +
                    "{$or: [" +
                        "{'trimType': { $in: ['Tag', 'Sticker', 'Sticker-Flexo', 'Sticker-Offset'] }}," +
                        "{'status': {$ne: 2}}" +
                    "]}" +
                "]" +
            "}")
    List<CommonDetailsCosting> getForSampleHead(String[] trimTypes);

    @Aggregation( pipeline = {
            "{" +
                //lookup operation is used to perform left outer join
                "$lookup: {" +
                    //from: The collection to be joined with the current collection
                    "from: 'MCustomer'," +
                    //let: To declare variables (usually assigned with the value of current collection)
                    //These variables will get used in the conditions part inside the pipeline
                    "let: { customerId: { $toObjectId: '$customerId' } }," +
                    //If we use let, then we must use pipeline
                    //If we had not used let, then we can use localField and foreign field variables
                    "pipeline: [" +
                        "{" +
                            //match, expr and eq is the syntax for equality comparison
                            "$match: {" +
                                "$expr: {" +
                                    //single $ indicates the field is from the newly joined collection
                                    //double $$ indicates the variable is from the let object initialized above
                                    "$eq: ['$_id', '$$customerId']" +
                                "}" +
                            "}" +
                        "}" +
                    "]," +
                    "as: 'MCustomer'" +
                "}" +
            "}",
            "{" +
                    //Unwinding the MCustomer array, since it will contain only one Object
                    //Usually lookup operation will result in arrays containing the newly joined collection
                    "$unwind: '$MCustomer'" +
            "}",
            "{" +
                    //Now performing the match operation to filter out only the documents matching the territory
                    "$match: {" +
                        "'MCustomer.territory': { $in :  ?0}" +
                    "}" +
            "}",
            "{" +
                    //The output response doesn't need the joined Customer Collection, so removing it after the filter operation
                    "$project: {'MCustomer': 0}" +
            "}"
            }
    )
    List<CommonDetailsCosting> getForTerritoryManager(String[] territoryIds);

    @Query(value = "{'executiveId': ?0}")
    List<CommonDetailsCosting> getForExecutive(String id);

    @Query(value = "{$and: [{'customerId': ?0}, {'status': {$gte: 4}}]}")
    List<CommonDetailsCosting> getForCustomer(String id);

    @Query(value = "{'archived': ?0}")
    List<CommonDetailsCosting> getByArchived(boolean archived);
}
