class Car {
   int year;
   String model;
   String car;
   String color;

   Car(int year, String model, String car, String color){
       this.year = year;
       this.model=model;
       this.car = car;
       this.color = color;
   }
 @Override
    public String toString(){
       return this.year + " " + this.car + " " + this.color + " " + this.model;
 }
}
