# Refactoring to patterns
[패턴을 활용한 리팩터링, 조슈아 케리에브스키 저, 윤성준, 조상민 역, 인사이트, 2006](http://book.naver.com/bookdb/book_detail.nhn?bid=2500103)


| Refactoring                                                  | Summary                                                      |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [Replace Constructors with Creation Methods](https://github.com/iamkyu/refactoring-to-patterns/blob/master/src/main/java/replace_constructors_with_creation_methods) | 어떤 클래스의 인스턴스를 생성할 때 여러 생성자 중 어떤 것을 호출해야 할지 결정하기 어렵다면, 인스턴스를 생성해 리턴하는 생성 메서드로 각 생성자를 대체하여 그 용도가 명확히 드러나도록 함. |
| Move Creation Knowledge to Factory                           |                                                              |
| [Encapsulate Classes with Factory](https://github.com/iamkyu/refactoring-to-patterns/blob/master/src/main/java/encapsulate_classes_with_factory) | 클라이언트가 한 패키지 내의, 공통 인터페이스를 가지는 클래스들의 인스턴스를 직접 생성하고 있다면, 그 클래스의 생성자를 클라이언트가 직접 볼 수 없게 하고 팩터리를 통해 그 인스턴스를 얻도록 함. |
| [Introduce Polymorphic Creation with Factory Method](https://github.com/iamkyu/refactoring-to-patterns/blob/master/src/main/java/introduce_polymorphic_creation_with_factory_method) | 한 상속 구조 내의 클래스들이 어떤 메서드를 각자 구현하는데 객체 생성 단계만 제외하고 나머지가 서로 유사하다면, 그 메서드를 수퍼 클래스로 옮기고 객체 생성은 팩터리 메서드에 맡김. |
| [Encapsulate Composite with Builder](https://github.com/iamkyu/refactoring-to-patterns/blob/master/src/main/java/encapsulate_composite_with_builder) | 컴포짓 구조를 생성하는 과정이 반복적으로 수행되고 복잡하다면 그 세부 사항을 처리하는 별도의 빌더를 제공하여 컴포짓 구조를 쉽게 생성할 수 있게 함. |
| Inline Singleton                                             |                                                              |
| [Compose Method](https://github.com/iamkyu/refactoring-to-patterns/blob/master/src/main/java/compose_method) | 어떤 메서드의 내부 로직이 한 눈에 이해하기 어렵다면, 그 로직을 의도가 잘 드러내는 동등한 수준의 작업을 하는 여러 단계로 나눔. |
| [Replace Conditional Logic with Strategy](https://github.com/iamkyu/refactoring-to-patterns/blob/master/src/main/java/replace_conditional_logic_with_strategy) | 메서드 내의 조건문을 통해 여러 개의 서로 다른 로직 가운데 어떤 것을 실행할지 선택하고 있다면, 각 로직에 해당하는 스트레티지 클래스를 만들고 각 스트레티지 인스턴스에 로직을 위임. |
| Move Embellishment to Decorator                              |                                                              |
| Replace State-Altering Conditionals with State               |                                                              |
| [Replace Implicit Tree with Composite](https://github.com/iamkyu/refactoring-to-patterns/blob/master/src/main/java/replace_implicit_tree_with_composite) | 실질적으로 트리 구조인 데이터를 String과 같은 기본 타입으로 표현하고 있다면, 그 기본 타입의 표현을 컴포짓 구조로 바꿈. |
| Replace Conditional Dispatcher with Command                  |                                                              |
| [Form Template Method](https://github.com/iamkyu/refactoring-to-patterns/blob/master/src/main/java/form_template_method) | 한 상속 구조 내의 어떤 두 서브클래스가 유사한 단위 작업을 같은 순서로 실행하는 메서드를 각자 구현한다면, 각 단위 작업을 별도의 메서드로 뽑아내어 두 메서드를 일반화하고 수퍼클래스로 올려 템플릿 메서드로 만듬. |
| Extract Composite                                            |                                                              |
| Replace One/Many Distinction with Composite                  |                                                              |
| Replace Hard-Coded Notifications with Observer               |                                                              |
| Unify Interfaces with Adapter                                |                                                              |
| Extract Adapter                                              |                                                              |
| Replace Implicit Language with Interpreter                   |                                                              |
| Replace Type Code with Class                                 |                                                              |
| Limit Instantiation with Singleton                           |                                                              |
| Introduce Null Object                                        |                                                              |
| Move Accumulation to Collecting Parameter                    |                                                              |
| Move Accumulation to Visitor                                 |                                                              |
| [Chain Constructor](https://github.com/iamkyu/refactoring-to-patterns/tree/master/src/main/java/chain_constructors) | 중복된 코드를 갖는 생성자가 여러 개 있다면, 생성자들이 서로 호출하게 함. |
| Unify Interfaces                                             |                                                              |
| Extract Parameter                                            |                                                              |

