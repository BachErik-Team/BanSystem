# BanSystem
This plugin allows you to ban players. I am currently actively developing the plugin and have many ideas and features in progress.

## Why Choose BanSystem?

BanSystem offers several compelling reasons to use it on your BungeeCord server:

1. **Efficient Player Management:** Ban and unban players effortlessly, access comprehensive ban histories, and enforce server rules effectively.
2. **Simplified Ban Templates:** Use predefined templates for common scenarios or customize them to fit your server's needs, ensuring consistent rule enforcement.
3. **Flexible Control:** Assign permissions, fine-tune ban durations, and manage player groups with ease, giving you full control over server discipline.
4. **Easy Configuration:** Quick installation, message customization, and adjustable ban durations make setup a breeze.
5. **Active Development:** Expect ongoing updates and future features like a mute system to keep your server up-to-date and secure.


## Commands
Command | Description
------- | -----------
`/ban <Player> [<Time>] <Reason>` | Ban a player
`/ban <Player> #<template-id>` | Ban a player using a template
`/unban <Player>` | Unban a player
`/baninfo <Player>` | Show the player's ban history
`/clearban(s) <Player>` | Clear all ban entries for a player
`/bantemplate list` | List ban templates
`/bantemplate add <time> <reason>` | Add a ban template
`/bantemplate edit <time> <reason>` | Edit a ban template
`/bantemplate remove <id>` | Remove a ban template
`/banreload` | Reload messages from configs

## Permissions
Permission | Description
---------- | -----------
`bansystem.ban` | Permission for the `/ban` command
`bansystem.ban.permanent` | Permission to use `/ban` with permanent bans
`bansystem.ban.<group>` | Maximum ban duration can be configured in `settings.yml`
`bansystem.unban` | Permission for the `/unban` command
`bansystem.baninfo` | Permission for the `/baninfo` command
`bansystem.bantemplate` | Permission for the `/bantemplate` command
`bansystem.reload` | Permission for the `/banreload` command

## Functions
- Ban players
- Unban players
- Show ban history
- Clear bans for specific players
- Create and use ban templates with IDs

## Requirements
- Java 17 or higher
- MySQL Database

## Installation
1. Move the plugin to the plugins folder of your BungeeCord server.
2. Restart BungeeCord.
3. Configure MySQL settings in the `mysql.yml` configuration file.
4. Optionally, customize individual messages in the `messages.yml` configuration file.
5. If needed, adjust the ban duration settings for different groups in the `settings.yml`.

## Coming Soon
- Mute system

## In Planning
- AI for the mute system
