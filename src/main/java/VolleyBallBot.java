import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.BotSession;

import java.util.List;
//Done! Congratulations on your new bot. You will find it at t.me/Vp_001_bot. You can now add a description, about section and profile picture for your bot, see /help for a list of commands. By the way, when you've finished creating your cool bot, ping our Bot Support if you want a better username for it. Just make sure the bot is fully operational before you do this.
//
//        Use this token to access the HTTP API:
//        665557558:AAF6rsGAq61XJE1HmrkTjX4RrRl83DhX9r4
//
//        For a description of the Bot API, see this page: https://core.telegram.org/bots/api

public class VolleyBallBot extends TelegramLongPollingBot {

    public static void main(String[] args) {
        System.out.println("test");

        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            BotSession botSession = botsApi.registerBot(new VolleyBallBot());
            System.out.println(botSession);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected VolleyBallBot() {
        super();
    }

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            switch (message.getText()) {
                case "/help":
                    sendMsg(message, "Can I help you?");
                    break;
                default:
                    sendMsg(message, "It's default message");
            }
        }
    }

    public void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public void onUpdatesReceived(List<Update> updates) {

    }

    @Override
    public String getBotUsername() {
        return "Vp_001_bot";
    }

    @Override
    public String getBotToken() {
        return "665557558:AAF6rsGAq61XJE1HmrkTjX4RrRl83DhX9r4";
    }
}