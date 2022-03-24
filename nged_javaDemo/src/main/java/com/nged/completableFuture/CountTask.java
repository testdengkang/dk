package com.nged.completableFuture;

public class CountTask  implements Task{
    @Override
    public void hande(TaskContext context) {
        context.count();
    }
}
