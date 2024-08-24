# Desafio de Backend - Magalu 📬
Este projeto é uma solução para um desafio de backend da empresa Magalu, focado no agendamento e envio de notificações. A aplicação permite o agendamento, cancelamento e envio de notificações com base em regras definidas, utilizando Java com Spring Boot.

## 🛠 Tecnologias Utilizadas
* Java 21
* Spring Boot
* Spring Data JPA
* Spring Scheduler
* MYSQL,POSTGRES,H2 Database (para fins de desenvolvimento e testes)

## 📁 Estrutura do Projeto
Principais Componentes
1. NotificationService

O NotificationService é responsável por gerenciar as notificações, desde o agendamento até o envio. Suas principais funcionalidades incluem:

* Agendamento de Notificações: Salva uma notificação agendada no banco de dados.
* Cancelamento de Notificações: Cancela uma notificação com base no seu ID.
* Verificação e Envio de Notificações: Verifica as notificações pendentes e envia aquelas cuja data e hora são anteriores ao tempo atual.

2. ScheduleNotificationDto

Este DTO encapsula os dados necessários para criar uma nova notificação, convertendo-os para uma entidade de Notification.

3. MagaluTaskScheduler

O MagaluTaskScheduler é responsável por verificar e processar as notificações periodicamente. A cada minuto, o agendador verifica as notificações pendentes e chama o serviço para processá-las.

Funcionamento Interno

* As notificações são agendadas e armazenadas no banco de dados.
* O MagaluTaskScheduler utiliza o Spring Scheduler para rodar uma tarefa a cada minuto, verificando se há notificações pendentes para envio.
* Após o envio, o status da notificação é atualizado para "SUCCESS". Em caso de falha, o status é marcado como "ERROR" e o sistema pode tentar reenviar.

Código de Exemplo
Aqui está uma visão geral do código do agendador de tarefas:

```
@Component
public class MagaluTaskScheduler {

    private static final Logger logger = LoggerFactory.getLogger(MagaluTaskScheduler.class);

    private final NotificationService notificationService;

    public MagaluTaskScheduler(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void checkTasks() {
        var dateTime = LocalDateTime.now();
        logger.info("Running at {}", dateTime);
        notificationService.checkAndSend(dateTime);
    }
}

```
## 🚀 Como Executar o Projeto
* Pré-requisitos
* JDK 21

Passos

1. Clone o repositório:
```
git clone https://github.com/seu-usuario/desafio-magalu-backend.git

```
2. Acesse a aplicação localmente em:
```
 http://localhost:8080
```
## 📦 Exemplos de Uso
* Agendar uma Notificação: Envie uma requisição POST com os detalhes da notificação para o endpoint /api/notifications/schedule.
* Cancelar uma Notificação: Envie uma requisição DELETE para /api/notifications/{id}.
* Verificar e Enviar Notificações: O agendador de tarefas roda automaticamente a cada minuto para processar as notificações pendentes.