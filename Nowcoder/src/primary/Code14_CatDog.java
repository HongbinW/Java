package primary;


import java.util.LinkedList;
import java.util.Queue;

public class Code14_CatDog {
    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    public static class PetEnter{
        private Pet pet;
        private long count;
        public PetEnter(Pet pet, long count){
            this.pet = pet;
            this.count = count;
        }
        public Pet getPet(){
            return this.pet;
        }
        public long getCount(){
            return this.count;
        }
        public String getEntryPetType(){
            return this.pet.getPetType();
        }
    }

    public static class DogCatQueue{
        private Queue<PetEnter> dogQ;
        private Queue<PetEnter> catQ;
        private long count;         //两个count，队列这个count是负责计数的，Pet里的count是负责保存计数的
        public DogCatQueue(){
            this.dogQ = new LinkedList<PetEnter>();
            this.catQ = new LinkedList<PetEnter>();
            this.count = 0;
        }
        public void add(Pet pet){
            if(pet.getPetType().equals("dog")){
                this.dogQ.add(new PetEnter(pet,this.count++));
            }else if(pet.getPetType().equals("cat")){
                this.catQ.add(new PetEnter(pet,this.count++));
            }else {
                throw new RuntimeException("err,not dog or cat");
            }
        }
        public Dog pollDog() {
            if (!this.isDogEmpty()) {
                return (Dog) this.dogQ.poll().getPet();
            } else {
                throw new RuntimeException("Dog queue is empty!");
            }
        }
        public Pet pollCat(){
            if(!this.isCatEmpty()){
                return (Cat)this.catQ.poll().getPet();
            }else {
                throw new RuntimeException("Cat queue is empty!");
            }
        }
//        public Pet pollAll(){
//            if(!this.isEmpty()){
//                if(this.dogQ.peek().getCount() > this.catQ.peek().getCount()){
//                    return this.catQ.poll().getPet();
//                }else {
//                    return this.dogQ.poll().getPet();
//                }
//            }else if(this.isDogEmpty()){
//                return this.catQ.poll().getPet();
//            }else if(this.isCatEmpty()){
//                return this.dogQ.poll().getPet();
//            }else {
//                throw new RuntimeException("err,queue is empty");
//            }
//        }
        public Pet pollAll() {
            if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
                if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
                    return this.dogQ.poll().getPet();
                } else {
                    return this.catQ.poll().getPet();
                }
            } else if (!this.dogQ.isEmpty()) {
                return this.dogQ.poll().getPet();
            } else if (!this.catQ.isEmpty()) {
                return this.catQ.poll().getPet();
            } else {
                throw new RuntimeException("err, queue is empty!");
            }
        }
        public boolean isDogEmpty(){
            return this.dogQ.isEmpty();
        }
        public boolean isCatEmpty(){
            return this.catQ.isEmpty();
        }
        public boolean isEmpty(){
            return this.dogQ.isEmpty() && this.catQ.isEmpty();
        }
    }
    public static void main(String[] args) {
        DogCatQueue test = new DogCatQueue();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        while (!test.isEmpty()) {
            System.out.println(test.pollDog().getPetType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getPetType());
        }
    }

}


//public class Code14_CatDog {
//
//    public static class Pet {
//        private String type;
//
//        public Pet(String type) {
//            this.type = type;
//        }
//
//        public String getPetType() {
//            return this.type;
//        }
//    }
//
//    public static class Dog extends Pet {
//        public Dog() {
//            super("dog");
//        }
//    }
//
//    public static class Cat extends Pet {
//        public Cat() {
//            super("cat");
//        }
//    }
//
//    public static class PetEnterQueue {
//        private Pet pet;
//        private long count;
//
//        public PetEnterQueue(Pet pet, long count) {
//            this.pet = pet;
//            this.count = count;
//        }
//
//        public Pet getPet() {
//            return this.pet;
//        }
//
//        public long getCount() {
//            return this.count;
//        }
//
//        public String getEnterPetType() {
//            return this.pet.getPetType();
//        }
//    }
//
//    public static class DogCatQueue {
//        private Queue<PetEnterQueue> dogQ;
//        private Queue<PetEnterQueue> catQ;
//        private long count;
//
//        public DogCatQueue() {
//            this.dogQ = new LinkedList<PetEnterQueue>();
//            this.catQ = new LinkedList<PetEnterQueue>();
//            this.count = 0;
//        }
//
//        public void add(Pet pet) {
//            if (pet.getPetType().equals("dog")) {
//                this.dogQ.add(new PetEnterQueue(pet, this.count++));
//            } else if (pet.getPetType().equals("cat")) {
//                this.catQ.add(new PetEnterQueue(pet, this.count++));
//            } else {
//                throw new RuntimeException("err, not dog or cat");
//            }
//        }
//
//        public Pet pollAll() {
//            if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
//                if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
//                    return this.dogQ.poll().getPet();
//                } else {
//                    return this.catQ.poll().getPet();
//                }
//            } else if (!this.dogQ.isEmpty()) {
//                return this.dogQ.poll().getPet();
//            } else if (!this.catQ.isEmpty()) {
//                return this.catQ.poll().getPet();
//            } else {
//                throw new RuntimeException("err, queue is empty!");
//            }
//        }
//
//
//        public Dog pollDog() {
//            if (!this.isDogQueueEmpty()) {
//                return (Dog) this.dogQ.poll().getPet();
//            } else {
//                throw new RuntimeException("Dog queue is empty!");
//            }
//        }
//
//        public Cat pollCat() {
//            if (!this.isCatQueueEmpty()) {
//                return (Cat) this.catQ.poll().getPet();
//            } else
//                throw new RuntimeException("Cat queue is empty!");
//        }
//
//        public boolean isEmpty() {
//            return this.dogQ.isEmpty() && this.catQ.isEmpty();
//        }
//
//        public boolean isDogQueueEmpty() {
//            return this.dogQ.isEmpty();
//        }
//
//        public boolean isCatQueueEmpty() {
//            return this.catQ.isEmpty();
//        }
//
//    }
//
//    public static void main(String[] args) {
//        DogCatQueue test = new DogCatQueue();
//
//        Pet dog1 = new Dog();
//        Pet cat1 = new Cat();
//        Pet dog2 = new Dog();
//        Pet cat2 = new Cat();
//        Pet dog3 = new Dog();
//        Pet cat3 = new Cat();
//
//        test.add(dog1);
//        test.add(cat1);
//        test.add(dog2);
//        test.add(cat2);
//        test.add(dog3);
//        test.add(cat3);
//
//        test.add(dog1);
//        test.add(cat1);
//        test.add(dog2);
//        test.add(cat2);
//        test.add(dog3);
//        test.add(cat3);
//
//        test.add(dog1);
//        test.add(cat1);
//        test.add(dog2);
//        test.add(cat2);
//        test.add(dog3);
//        test.add(cat3);
//        while (!test.isDogQueueEmpty()) {
//            System.out.println(test.pollDog().getPetType());
//        }
//        while (!test.isEmpty()) {
//            System.out.println(test.pollAll().getPetType());
//        }
//    }
//
//}

