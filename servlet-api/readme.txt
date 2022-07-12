1.servlet
    1）servlet 生命周期：四个阶段 -> 实例化 初始化 服务 销毁
    2）servlet中的初始化方法有两个：init() init(config)
       如果我们想在初始化时做一些准备操作那么可以重写init()方法
    3）在web.xml中配置servlet
        <init-param>
            <param-name>hello</param-name>
            <param-value>world</param-value>
        </init-param>
    4）用注解的方式配置servlet
        @WebServlet(urlPatterns = {"/demo01"},
                initParams = {
                        @WebInitParam(name = "hello", value = "World"),
                        @WebInitParam(name = "uname", value = "lili")
                })


2.学习Servlet中的ServletContext和<context—param>


3.什么是业务层
    1）MVC：
        V(View)视图层：用于展示数据以及和用户交互的一个通道
        C(controller)控制层：能够接受用户的请求，具体的业务功能还是借助于模型组件来完成
        M(Model)模型层：模型分为很多种：有比较简单的pojo/vo(value object)（数据的载体），有业务模型组件，还有数据访问层组件
            a) pojo/vo -> 值对象
            b) DAO -> 数据对象
            c) BO(Business Object) -> 业务对象
        区分业务对象与数据访问对象
            a) DAO中的方法都是单精度方法（或称之为细粒度方法）。什么是单精度：一个方法只考虑一个操作，比如 添加->那就只有Insert 查询->那就只有SELECT……
            b) BO中的方法属于业务方法，而实际中的业务是比较复杂的，因此业务方法的粒度是比较粗的
                注册这个功能属于业务功能，也就是说注册这个方法属于业务方法。
                那么这个业务方法中包含了多个DAO方法，也就是说，注册这个业务功能需要通过多个DAO方法的组合调用，从而完成注册功能的开发。
                    注册：
                        1.检查该用户是否已经注册 - DAO中的select操作
                        2.向用户表新增一条新用户记录 - DAO中的insert操作
                        3.向用户积分表新增一条记录（新用户默认初始化积分100分）- DAO中的insert操作
                        4.向系统消息表新增一条记录（某某某用户注册了 需要根据某某某方式向他推送信息）- DAO中的insert操作



