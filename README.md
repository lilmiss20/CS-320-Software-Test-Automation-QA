# CS-320 Software Test Automation and Quality Assurance

## Course Overview

Throughout CS-320, I learned how to develop and test software using automated testing techniques. For Project One, I developed Contact, Task, and Appointment services and used JUnit tests to verify that they met their requirements. For Project Two, I reflected on my testing strategies, results, and the importance of software quality.

## How can I ensure that my code, program, or software is functional and secure?

I can ensure my software is functional and secure by understanding the requirements, writing tests that verify expected behavior, and checking how the program handles invalid inputs. During Project One, I used JUnit to test my Contact, Task, and Appointment services. I tested valid and invalid values, boundary conditions, duplicate IDs, and exception handling. I also verified that failed operations did not change existing valid data.

I learned that high test coverage is helpful, but it does not automatically mean software is completely secure or free of defects. Code reviews, secure programming practices, and additional security testing are also important, especially when an application handles sensitive information.

## How do I interpret user needs and incorporate them into a program?

I start by reviewing the requirements and identifying what the user needs the software to accomplish. I then break those requirements into smaller functions that I can develop and test individually.

In Project One, each service had specific requirements for creating, updating, and deleting information. For example, the Contact service required validation of contact IDs, names, phone numbers, and addresses. I used those requirements to determine how the program should behave and what my JUnit tests needed to verify.

This experience helped me understand that software can run without errors and still fail to meet user expectations if the requirements are misunderstood.

## How do I approach designing software?

When designing software, I begin by understanding the purpose of the application and breaking it into smaller, manageable components. I consider how each component should function, what information it needs to process, and how it can be tested.

Working with separate Contact, Task, and Appointment services helped me understand the importance of organizing code so individual features can be developed and tested independently. I also learned that testing should be considered throughout development rather than waiting until the application is finished.

Moving forward, I plan to continue using requirements-based testing, automated JUnit tests, and code reviews to create software that is organized, maintainable, and reliable.
