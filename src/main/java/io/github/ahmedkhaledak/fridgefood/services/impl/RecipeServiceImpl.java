package io.github.ahmedkhaledak.fridgefood.services.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.TotalHits;
import co.elastic.clients.elasticsearch.core.search.TotalHitsRelation;
import io.github.ahmedkhaledak.fridgefood.ElasticsearchCreator;
import io.github.ahmedkhaledak.fridgefood.models.Recipe;
import io.github.ahmedkhaledak.fridgefood.services.RecipeService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeServiceImpl implements RecipeService {
    @Override
    public String createRecipe(Recipe recipe) throws IOException {
        ElasticsearchClient client = ElasticsearchCreator.getEsClient();
        IndexResponse response = client.index(i -> i
                .index("recipes")
                .id(recipe.getId())
                .document(recipe)
        );
        return response.id();
    }

    @Override
    public Recipe getRecipeById(String recipeId) throws IOException {
        ElasticsearchClient esClient = ElasticsearchCreator.getEsClient();
        GetResponse<Recipe> response = esClient.get(g -> g.index("recipes").id(recipeId), Recipe.class);
        if (response.found()) {
            Recipe recipe = response.source();
            return recipe;
        }
        return null;
    }

    @Override
    public List<Recipe> getRecipesByName(String name) throws IOException {
        ElasticsearchClient esClient = ElasticsearchCreator.getEsClient();
        SearchResponse<Recipe> response = esClient.search(s -> s
                .index("recipes")
                .query(q -> q
                        .match(t -> t
                                .field("name")
                                .query(name))
                ),
                Recipe.class);


        TotalHits total = response.hits().total();
        boolean isExactResult = total.relation() == TotalHitsRelation.Eq;

        if (isExactResult) {
            System.out.println("There are " + total.value() + " results");
        } else {
            System.out.println("There are more than " + total.value() + " results");
        }

        List<Hit<Recipe>> hits = response.hits().hits();
        List<Recipe> recipes = new ArrayList<>();
        for(Hit<Recipe> hit : hits) {
            Recipe recipe = hit.source();
            recipes.add(recipe);
        }
        return recipes;
    }
}
