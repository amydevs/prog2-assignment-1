{ pkgs ? import ./pkgs.nix {}, ci ? false }:

with pkgs;
let jdk17overide = jdk17.override { enableJavaFX = true; };
in
mkShell {
  nativeBuildInputs = [
    openjfx
    jdk17overide
  ];
  shellHook = ''
    export LD_LIBRARY_PATH="$APPEND_LIBRARY_PATH:$LD_LIBRARY_PATH"
    set -o allexport
    . ./.env
    set +o allexport
    set -v
    ${
      lib.optionalString ci
      ''
      set -o errexit
      set -o nounset
      set -o pipefail
      shopt -s inherit_errexit
      ''
    }
    mkdir --parents "$(pwd)/tmp"



    set +v
  '';
}
