package com.muri.web.document;

//import org.apache.mahout.cf.taste.common.TasteException;
//import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
//import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
//import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
//import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
//import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
//import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
//import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
//import org.apache.mahout.cf.taste.model.DataModel;
//import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
//import org.apache.mahout.cf.taste.recommender.RecommendedItem;
//import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
//import org.apache.mahout.cf.taste.similarity.UserSimilarity;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;

/**
 * Created by andrei.muresan on 10/2/2015.
 */
public class Mahout {

    public static void main(String[] args)/* throws IOException, TasteException*/ {
//        DataModel model = new FileDataModel(new File("c:\\tool\\files\\dataset.csv"));
//        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
//        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
//        UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
//        List<RecommendedItem> recommendations = recommender.recommend(2, 3);
//        for (RecommendedItem recommendation : recommendations) {
//            System.out.println(recommendation);
//        }
//        recommand(model);
//        recommand(model);
//        recommand(model);
//        recommand(model);
    }

//    private static void recommand(DataModel model) throws TasteException {
//        RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
//        RecommenderBuilder builder = new MyRecommenderBuilder();
//        double result = evaluator.evaluate(builder, null, model, 0.9, 1.0);
//        System.out.println(result);
//    }

}
