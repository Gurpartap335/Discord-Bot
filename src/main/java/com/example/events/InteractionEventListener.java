package com.example.events;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class InteractionEventListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        Scanner s = new Scanner(System.in);
        super.onSlashCommandInteraction(event);

        switch (event.getName()) {
            case "flash-cards":
                event.reply("Here are your flash cards").setEphemeral(true).queue();
                break;
            case "quiz":
                event.reply("Quiz command").setEphemeral(true).queue();
                break;
            case "slash-cmd":
                event.reply("Slash Command").setEphemeral(true).queue();
                break;
        }
    }
}
