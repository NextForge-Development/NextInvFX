# InvFX — Inventory UI Framework (Alpha)

![Status](https://img.shields.io/badge/status-alpha-yellow?style=for-the-badge)
![Shade Ready](https://img.shields.io/badge/shade-ready-blueviolet?style=for-the-badge)
![Platform](https://img.shields.io/badge/platform-paper-green?style=for-the-badge)
![Java](https://img.shields.io/badge/java-21+-orange?style=for-the-badge)
[![License](https://img.shields.io/badge/license-MIT-blue?style=for-the-badge)](https://opensource.org/license/mit)
![Built By](https://img.shields.io/badge/built_by-NextForge-purple?style=for-the-badge)

> [!WARNING]
> InvFX is currently an **unstable alpha**.  
> APIs, packages, and internals may change at any time without notice.  
> **Do not use in production** unless you are comfortable with frequent breaking changes.

---

## 🚀 What is InvFX?

InvFX is a **Java inventory UI framework** for Minecraft plugin developers.  
It provides a **modern, composable API** for building **custom GUIs** on Paper servers — while being **library-first**.

- No `JavaPlugin` entry point.
- No heavy setup.
- Just **shade the API** into your own plugin and build inventories like real UI components.

---

## ✨ Features (alpha stage)

- **API-first design** — clear separation of `api`, `spi`, `impl`, and `binding` packages.
- **Views** — describe what should be displayed (`PagedView`, `ConfirmView`, `ListView`, etc.).
- **Render pipeline** — efficient diff-based updates, only changed slots are redrawn.
- **Controllers & Events** — handle clicks, drags, closes, opens, cursor changes.
- **Adapters** — Bukkit/Paper bindings are thin and optional, keeping the core platform-agnostic.
- **Extras** — pre-built components: nav bars, confirm dialogs, search inputs, animated toasts.
- **Test-friendly** — ships with mock adapters and schedulers so you can unit test without Bukkit.
- **Shade-ready** — designed to be relocated into your plugin to avoid conflicts.

---

## 🛠 Examples

### Example 1 — Confirm Dialog
```java
var mm = MiniMessage.miniMessage();

ConfirmView confirm = new ConfirmView(
    mm.deserialize("<yellow>Delete item?"),
    invfx.getItemProvider(),
    result -> {
        if (result) {
            player.sendMessage("Item deleted!");
        } else {
            player.sendMessage("Cancelled.");
        }
    }
);

invfx.open(player, confirm);
```

### Example 2 - Simple List
```java
ListView<String> listView = new ListView<>(
    List.of("Sword", "Bow", "Shield"),
    invfx.getItemProvider(),
    5, // content rows
    item -> MiniMessage.miniMessage().deserialize("<aqua>" + item),
    selected -> player.sendMessage("You picked: " + selected)
);

invfx.open(player, listView);
```

---

## 🧭 Roadmap
- [x] Core API design and implementation.
- [x] Basic views: `PagedView`, `ConfirmView`, `ListView`.
- [x] Event handling and controllers.
- [x] Paper adapter and scheduler.
- [ ] Core API stabilization
- [ ] Improved diff-renderer performance
- [ ] More pre-built widgets & layouts (TabView, ScrollView, Animations)
- [ ] Documentation & developer guide
- [ ] First stable release

--- 

## 📄 License
This project is licensed under the [MIT License](https://opensource.org/license/mit). See the [LICENSE](LICENSE) file for details.