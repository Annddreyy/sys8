class Main {
    public static void main(String[] args) throws InterruptedException {
        QuestionThread egg = new QuestionThread("Egg");
        QuestionThread chicken = new QuestionThread("Chicken");

        egg.start();
        chicken.start();

        while (true) {
            if (!chicken.isAlive()){
                egg.join();
                System.out.println("Egg");
                break;
            }
            else if (!egg.isAlive()) {
                chicken.join();
                System.out.println("Chicken");
                break;
            }
        }
    }
}

class QuestionThread extends Thread {
    QuestionThread(String name) {
        setName(name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int)(Math.random() * 1000L));
            System.out.println(getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}