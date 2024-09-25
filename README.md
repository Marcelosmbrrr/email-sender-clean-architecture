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
  - class EmailSenderService <bold>injects interface</bold> EmailSenderGateway
    - By injecting the Gateway interface, which is an adapter, Spring actually injects the class that implements this interface, which is from Infra.

Controller (Implements Service)
- controller that implements service:
    - class EmailSenderController injects EmailSenderService

Adapters (Interface for most external layer)
- interface EmailSenderGateway

Infra (Implements the Adapter and is inject by EmailSenderService)
- Concrete implementation of the external e-mail service
- Different email services will have the same methods, but with their own implementation
- The EmailSenderService indirectly injects one of these classes by injecting the interface they implement - it looks for the "current e-mail service in use", which is what implements the interface
- SesEmailSender is the only created, but if it had another one, a way would have to be created to choose which one will be injected into the EmailSenderService




