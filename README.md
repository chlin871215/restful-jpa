# 柏成箖0812HW

* 以 Order & Meal 為例進行 spring-boot-restful-jpa-practice

##  Model
### Meal
* 餐點編號 private int id 
* 餐點名稱 private String name;
* 餐點價格 private int price;   
* 餐點描述 private String description; 

### Order
* 訂單編號 private int id;
* 訂單總價 private int totalprice;
* 訂單店員 private String waiter;
* 訂單餐點 private List<Meal> mealList;

## Service
### MealService
  * public List<Meal> getAllMeal(){...} </br>
    -> 使用 Get 取得全部餐點
  * public Meal getMealById(int id){...} </br>
    -> 使用 Get 透過餐點編號取得餐點
  * public String createMeal(CreateMealRequest request){...} </br>
    -> 使用 Post 新增餐點
  * public String updateMeal(int id, UpdateMealRequest request){...} </br>
    -> 使用 Put 更新餐點
  * public String deleteMeal(int id){...} </br>
    -> 使用 Delete 刪除餐點
    
### OrderService
  * public List<Order> getAllOrders(){...} </br>
    -> 使用 Get 取得全部訂單
  * public Order getOrderBySeq(int seq){...} </br>
    -> 使用 Get 透過訂單編號取得訂單
  * public String createOrder(CreateOrderRequest createOrderRequest){...} </br>
    -> 使用 Post 新增訂單
  * public String updateOrder(int seq, UpdateOrderRequest updateOrderRequest){...} </br>
    -> 使用 Put 更新訂單
  * public String deleteOrderBySeq(int seq) </br>
    -> 使用 Delete 刪除訂單
    

