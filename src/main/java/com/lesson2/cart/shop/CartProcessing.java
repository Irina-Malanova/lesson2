package com.lesson2.cart.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class CartProcessing {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Cart cart;
    private void deleteProductFromCart(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите номер продукта из и удалите его из корзины, номера продуктов можно указывать через пробел, окончание удаления /");
            System.out.println("В вашей корзине следующие продукты:");
            cart.showProduct();
            String str = sc.nextLine();
            if (str.equals("/")) {
                break;
            } else {
                try {
                    String[] arr = str.split(" ");
                    for (int i = 0; i < arr.length; i++) {
                        Product item = productRepository.getById(Integer.parseInt(arr[i]));
                        if(item == null) throw new Exception();
                        cart.deleteProduct(item);
                    }
                } catch (Exception e) {
                    System.out.println("Введен некорректный номер");
                }
            }
        }
        System.out.println("В вашей корзине следующие продукты:");
        cart.showProduct();
    }
    public void processCart() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите номер продукта из списка и добавьте его в корзину, номера продуктов можно указывать через пробел, окончание выбора /\nпереход на удаление \\");
            printProductList();
            String str = sc.nextLine();
            if (str.equals("/")) {
                break;
            } else if (str.equals("\\")) {
                deleteProductFromCart();
            } else {
                try {
                    String[] arr = str.split(" ");
                    for (int i = 0; i < arr.length; i++) {
                        Product item = productRepository.getById(Integer.parseInt(arr[i]));
                        if(item == null) throw new Exception();
                        cart.addProduct(item);
                    }
                } catch (Exception e) {
                    System.out.println("Введен некорректный номер");
                }
            }
        }
        System.out.println("В вашей корзине следующие продукты:");
        cart.showProduct();
        System.out.println("Ваша корзина: " + cart);
    }

    private void printProductList() {
        for (Product item : productRepository.getAll()) {
            item.printProduct();
        }
    }
}
