package service.response;

import model.Category;

import java.util.HashMap;

public class GetCategoriesResponse {

    HashMap<Category, Integer> categoryHashMap;

    public GetCategoriesResponse(HashMap<Category, Integer> categoryHashMap) {
        this.categoryHashMap = categoryHashMap;
    }

    public HashMap<Category, Integer> getCategoryHashMap() {
        return categoryHashMap;
    }
}
