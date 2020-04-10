/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package sample.kotlin.spring

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class AppIT {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun getAllRides() {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andReturn()
    }

    @Test
    fun getSingleMeal() {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andReturn()
    }

    @Test
    fun returnNotFoundForInvalidSingleMeal() {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/6")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound)
                .andReturn()
    }

    @Test
    fun shouldAddNewMealSuccessfully() {
        val jsonMeal = """{
	                        "name": "Tortilla",
	                        "description": "Spanish Omelette",
	                        "ingredients": {
                                "Onion": 1,
                                "Potatoes": 3
	                            }
                            }"""

        mockMvc.perform(MockMvcRequestBuilders.post("/meal")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMeal)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andReturn()
    }


}
