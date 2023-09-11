import com.sun.corba.se.spi.orbutil.closure.Closure

class Person {
    String name
    int age
}

// 定义闭包 cc
def cc = {
    delegate.name = "hanmeimei"
    delegate.age = 124
}

// 创建一个 Person 对象
Person person = new Person()

// 调用闭包 cc，设置 person 对象的属性
cc.delegate = person
cc.call()


// 标准写法，method1 就是一个闭包 (>▽<)
def method1 = { name,age ->
    name + age
    println(name + age)
}

// 调用方式
method1.call(123,888)
method1(123,888)

// 默认有一个 it 表示单个参数
def method3 = { "Hello World!$it" }

// 强制不带参数
def method2 = {  ->
    name + age
}

// 作为方法参数使用
def to(x, y, Closure closure) {
    x + y + closure(111)
}

println "Name: ${person.name}, Age: ${person.age}"


