package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class RecipeServiceImplTest {

    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void getRecipes() {
        Recipe recipe = new Recipe();
        HashSet<Recipe> recipeData = new HashSet<>();
        recipeData.add(recipe);

        Mockito.when(recipeService.getRecipes()).thenReturn(recipeData);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(1, recipes.size());
        Mockito.verify(recipeRepository, Mockito.times(1)).findAll();
    }
}