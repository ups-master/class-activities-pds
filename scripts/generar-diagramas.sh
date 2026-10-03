#!/usr/bin/env bash
# Genera un SVG por cada .puml del repo en <carpeta-del-puml>/diagramas/.
# Requisitos: Java y Graphviz (dot). Si no hay plantuml.jar, lo descarga.
set -euo pipefail

RAIZ="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
VERSION="1.2025.4"
PLANTUML_JAR="${PLANTUML_JAR:-$HOME/.cache/plantuml/plantuml.jar}"

if [ ! -f "$PLANTUML_JAR" ]; then
  mkdir -p "$(dirname "$PLANTUML_JAR")"
  curl -sL -o "$PLANTUML_JAR" \
    "https://repo1.maven.org/maven2/net/sourceforge/plantuml/plantuml/$VERSION/plantuml-$VERSION.jar"
fi

cd "$RAIZ"
find . -name '*.puml' -not -path '*/target/*' -not -path './.git/*' | sort | while read -r f; do
  java -Djava.awt.headless=true -jar "$PLANTUML_JAR" -tsvg -o diagramas "$f"
  echo "OK $f"
done
