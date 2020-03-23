//package com.tzl;
//
//import com.netflix.hystrix.HystrixCommand;
//import com.netflix.hystrix.HystrixCommandGroupKey;
//
///**
// * Hystrix的回退模式
// * Hystrix 的回退机制比较灵活，你可以在 A 命令的回退方法中执行 B 命令，如果 B 命令
//    也执行失败，同样也会触发 B 命令的回退，这样就形成一种链式的命令执行
// */
//public class CommandA extends HystrixCommand<String> {  //…省略其他代码
//    protected CommandA(Setter setter) {
//        super(setter);
//    }
//
//    protected String run() throws Exception {
//        throw new RuntimeException();
//    }
//    protected String getFallback() {
//        return new CommandB().execute();
//    }
//}
//
//class CommandB extends HystrixCommand<String> {  //…省略其他代码
//    protected CommandB(HystrixCommandGroupKey group) {
//        super(group);
//    }
//    protected String run() throws Exception {
//        throw new RuntimeException();
//    }
//    protected String getFallback() {
//        return new CommandB().execute();
//    }
//}