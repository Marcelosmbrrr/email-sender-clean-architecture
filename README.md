# Clean Architecture with E-mail Service

Core (Business):
- entities
- use case interfaces:
  interface EmailSenderUseCase
- exception interfaces:
  interface EmailServiceException

Application (Use Case Implementation):
- services:
  - class EmailSenderService implements interface EmailSenderUseCase;
  - class EmailSenderService <bold>injects interface</bold> EmailSenderAdapter
    - By injecting the EmailSenderAdapter interface, Spring actually injects the class that implements this interface, which is from Infra.

Controller (Implements Service)
- controller that implements service:
    - class EmailSenderController injects EmailSenderService

Adapters (Interface between Infra and Application)
- interface EmailSenderAdapter
  - This interface is implemented by the infra classes
  - By this way, which infra class Spring injects into the Application layer is irrelevant

Infra (Implements the Adapter and is inject by EmailSenderService)
- Concrete implementation of the external e-mail service
- Different email services will have the same methods, but with their own implementation
- The EmailSenderService indirectly injects one of these classes by injecting the interface they implement - it looks for the "current e-mail service in use", which is what implements the interface
- SesEmailSender is the only created, but if it had another one, a way would have to be created to choose which one will be injected into the EmailSenderService




