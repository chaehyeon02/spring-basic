package hello.core.singleton;


//강의 5-4-1
public class StatefulService {

//    private int price; //상태를 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; //여기가 문제!

        //무상태로 만들려면 위에 price 선언 없애고, 함수 반환값 바꾸고 (void -> int)
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
