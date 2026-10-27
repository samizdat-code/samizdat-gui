# samizdat-gui

The standalone GTK4 client for [Samizdat](https://github.com/yogthos/samizdat).
It displays a run's live solution graph, branch details, approvals, and
intervention controls. The GUI is a strict HTTP client: the server owns all run
state, engines, and persistence.

## Requirements

- Jolt 0.8.22 or newer
- GTK4 and OpenGL runtime libraries
- A running Samizdat server

Samizdat and the Glimmer toolkit are fetched as pinned Git dependencies.

## Running

Start the server in a Samizdat checkout:

```bash
jolt serve
```

Start the GUI in this checkout:

```bash
jolt gui
```

The GUI connects to `http://127.0.0.1:3985` by default. Set `SAMIZDAT_URL` to a
complete server URL, or `HARNESS_PORT` when only the loopback port differs:

```bash
SAMIZDAT_URL=http://127.0.0.1:4000 jolt gui
HARNESS_PORT=4000 jolt gui
```

## Testing

```bash
jolt test
./dev/cold-load.sh
jolt -A:test -e '(require (quote samizdat.gui.core))'
```

The test suite covers the toolkit-free client, graph, input, rendering, and
approval logic. The load checks cover native dependencies and namespace load
order without requiring a display.

## License

GPL-3.0-or-later. See `LICENSE`.
