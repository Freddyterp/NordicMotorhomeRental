package com.example.nordic_motorhome;

import com.example.nordic_motorhome.Models.Car;
import com.example.nordic_motorhome.Repository.CarRepo;
import com.example.nordic_motorhome.Service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


//Theis
@SpringBootTest
class NordicMotorhomeApplicationTests {


    //Arrange objects for use in tests
    @Autowired
    private CarService service;

    @MockBean
    private CarRepo repo;

    //Test for getter method
    @Test
    public void getModelTest(){
        //arrange
        Car testCar = new Car(800, "Testo", "Testy", 2000, 2001, 7);
        //act
        String expected = "Testo";
        String actual = testCar.getModel();
        //assert
        assertEquals(expected, actual);
    }

    //Test using mockito method when().then() for fetchAllItems()
    @Test
    public void fetchAllItemsTest() {
        when(repo.fetchAllItems()).thenReturn(
                Stream.of(
                        new Car(700, "Testo", "Testy",
                                2000, 2001, 7),
                        new Car(701, "Testo2", "Testy2", 2001, 2002, 8))
                        .collect(Collectors.toList()));
        assertEquals(2, service.fetchAllItems().size());
    }

    //Test using mockito framework for method findById()
    @Test
    public void findByIdTest(){
        int testId = 800;
        Car testCar = new Car(800, "Testo", "Testy", 2000, 2001, 7);

        when(repo.findCarById(testId)).thenReturn((testCar));
        assertEquals("Testy", service.findById(800).getBrand());


    }


}
