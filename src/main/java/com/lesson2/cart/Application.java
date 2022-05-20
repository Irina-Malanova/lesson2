package com.lesson2.cart;

import com.lesson2.cart.configuration.ApplicatioConfiguration;
import com.lesson2.cart.shop.CartProcessing;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicatioConfiguration.class);
        System.out.println(context);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Загрузите новую корзину (продолжить - <enter>, закончить - /):");
            String str = sc.nextLine();
            if (str.equals("/")) {
                break;
            }
            CartProcessing cartProcessing = context.getBean(CartProcessing.class);
            cartProcessing.processCart();
        }
    }
}
