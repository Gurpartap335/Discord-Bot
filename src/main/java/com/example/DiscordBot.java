package com.example;

import com.example.events.InteractionEventListener;
import com.example.events.MessageEventListener;
import com.example.events.ReadyEventListener;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;


import javax.security.auth.login.LoginException;
import java.io.IOException;


public class DiscordBot {

    public static Dotenv config;
    public static void main(String[] args) throws LoginException, IOException {

        config = Dotenv.configure().directory("/").filename(".env").load();
        String token = config.get("TOKEN");

        JDABuilder jdaBuilder = JDABuilder.createDefault(token);
        jdaBuilder.setActivity(Activity.playing("with your mom"));
        JDA jda =  jdaBuilder
                  .enableIntents(GatewayIntent.DIRECT_MESSAGES, GatewayIntent.GUILD_MESSAGES)
                  .addEventListeners(new ReadyEventListener(), new MessageEventListener(), new InteractionEventListener())
                  .build();

        jda.upsertCommand("slash-cmd", "This is a slash command").queue();
        jda.upsertCommand("flash-cards", "Lists all flash cards set").queue();
        jda.upsertCommand("quiz", "Gives you a random quiz").queue();
        jda.upsertCommand("intro", "Ask for name").queue();
    }
}
