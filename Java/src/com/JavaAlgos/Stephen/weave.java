package com.JavaAlgos.Stephen;

public class weave {
    public static void main(String[] args){
        QueueAva QA1 = new QueueAva();
        QueueAva QA2 = new QueueAva();

        for(int i = 0; i < 100; i++){
            int an = i + 20;
            QA1.add(an);
        }

        for(int i = 0; i < 10; i++){
            int an = i + 10;
            QA2.add(an);
        }

        QueueAva QAQ = new QueueAva();

        while(QA1.peek() != 0 && QA2.peek() != 0){
            QAQ.add(QA1.remove());
            QAQ.add(QA2.remove());
        }
        while(QA1.peek() != 0){
            QAQ.add(QA1.remove());
        }
        while(QA2.peek() != 0){
            QAQ.add(QA2.remove());
        }

    }


}
