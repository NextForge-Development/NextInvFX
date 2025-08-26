# InvFX — Inventory UI Framework (Prototype)

![Status](https://img.shields.io/badge/status-prototype-red?style=for-the-badge)
![Shade Ready](https://img.shields.io/badge/shade-ready-blueviolet?style=for-the-badge)
![Platform](https://img.shields.io/badge/platform-bukkit%20%7C%20paper-green?style=for-the-badge)
![Java](https://img.shields.io/badge/java-21+-orange?style=for-the-badge)
![License](https://img.shields.io/badge/license-TBD-lightgrey?style=for-the-badge)
[![forthebadge](data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyMDguNTc4MTYzMTQ2OTcyNjYiIGhlaWdodD0iMzUiIHZpZXdCb3g9IjAgMCAyMDguNTc4MTYzMTQ2OTcyNjYgMzUiPjxyZWN0IHdpZHRoPSI4OC4yMDMxNDAyNTg3ODkwNiIgaGVpZ2h0PSIzNSIgZmlsbD0iI2RjOTVlYiIvPjxyZWN0IHg9Ijg4LjIwMzE0MDI1ODc4OTA2IiB3aWR0aD0iMTIwLjM3NTAyMjg4ODE4MzYiIGhlaWdodD0iMzUiIGZpbGw9IiNiZDEwZTAiLz48dGV4dCB4PSI0NC4xMDE1NzAxMjkzOTQ1MyIgeT0iMjEuNSIgZm9udC1zaXplPSIxMiIgZm9udC1mYW1pbHk9IidSb2JvdG8nLCBzYW5zLXNlcmlmIiBmaWxsPSIjRkZGRkZGIiB0ZXh0LWFuY2hvcj0ibWlkZGxlIiBsZXR0ZXItc3BhY2luZz0iMiI+QlVJTFQgQlk8L3RleHQ+PHRleHQgeD0iMTQ4LjM5MDY1MTcwMjg4MDg2IiB5PSIyMS41IiBmb250LXNpemU9IjEyIiBmb250LWZhbWlseT0iJ01vbnRzZXJyYXQnLCBzYW5zLXNlcmlmIiBmaWxsPSIjRkZGRkZGIiB0ZXh0LWFuY2hvcj0ibWlkZGxlIiBmb250LXdlaWdodD0iOTAwIiBsZXR0ZXItc3BhY2luZz0iMiI+TkVYVEZPUkdFPC90ZXh0Pjwvc3ZnPg==)](https://nextforge.gg)

> [!CAUTION]
> InvFX is currently an **unstable prototype**.  
> There is no public repository or official release yet.  
> APIs, packages, and internals may change at any time without notice.  
> **Do not use in production** unless you are comfortable with frequent breaking changes.

---

## 🚀 What is InvFX?

InvFX is a **Java inventory UI framework** for Minecraft plugin developers.  
It provides a **modern, composable API** for building **custom GUIs** on Bukkit/Paper servers — while being **library-first**.  

- No `JavaPlugin` entry point.  
- No heavy setup.  
- Just **shade the API** into your own plugin and build inventories like real UI components.

---

## ✨ Features (prototype stage)

- **API-first design** — clear separation of `api`, `spi`, `impl`, and `binding` packages.  
- **Views** — describe what should be displayed (`PagedView`, `TabbedView`, `ScrollView`, etc.).  
- **Render pipeline** — efficient diff-based updates, so only changed slots are redrawn.  
- **Controllers & Events** — handle clicks, drags, closes, opens, cursor changes.  
- **Adapters** — Bukkit/Paper bindings are thin and optional, making the core platform-agnostic.  
- **Extras** — pre-built components: nav bars, confirm dialogs, search inputs, animated toasts.  
- **Test-friendly** — ships with mock adapters and schedulers so you can unit test without Bukkit.  
- **Shade-ready** — designed to be relocated into your plugin to avoid conflicts.

---

## 🛠 Example (early draft)

```java
public class ExampleGui {

    public void open(Player player) {
        View view = new PagedView(List.of(
            new ItemStack(Material.DIAMOND),
            new ItemStack(Material.EMERALD),
            new ItemStack(Material.GOLD_INGOT)
        ));

        RenderContext ctx = new RenderContext(player, new DefaultItemProvider());
        Window window = new Window(player, view, new BukkitInventoryAdapter());

        window.open(ctx);
    }
}
```

---

## 🧭 Roadmap
- [ ] Core API stabilization
- [ ] Improved diff-renderer performance
- [ ] More pre-built widgets & layouts
- [ ] Documentation & developer guide
- [ ] First stable release 

--- 

## 📜 License

Currently unlicensed. Prototype stage.
Future versions will include an open-source license once the API stabilizes.
