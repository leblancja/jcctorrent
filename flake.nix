{
  description = "Java Development Environment";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs = {
    self,
    nixpkgs,
    flake-utils,
  }:
    flake-utils.lib.eachDefaultSystem (
      system: let
        pkgs = import nixpkgs {inherit system;};

        jdk = pkgs.jdk25;
        maven = pkgs.maven;
        gradle = pkgs.gradle;
      in {
        devShells.default = pkgs.mkShell {
          buildInputs = [jdk maven gradle];

          NIX_LD_LIBRARY_PATH = pkgs.lib.makeLibraryPath [
            pkgs.stdenv.cc.cc
            pkgs.openssl
            pkgs.xorg.libXtst
            pkgs.glib
            pkgs.xorg.libXxf86vm
            pkgs.libGL
          ];
          NIX_LD = pkgs.lib.fileContents "${pkgs.stdenv.cc}/nix-support/dynamic-linker";

          shellHook = ''
                     mkdir -p "$PWD/.m2/bin"
                     mkdir -p "$PWD/.gradle"

                     export JDK_DIR=$PWD/.jdk
                     export PATH=$PWD/.m2/bin:$PATH
                     export MAVEN_USER_HOME=$PWD/.m2
                     export GRADLE_USER_HOME=$PWD/.gradle

                     ln -sfn ${jdk} "$JDK_DIR"

                     export JAVA_HOME=$JDK_DIR/lib/openjdk
            export LD_LIBRARY_PATH=$NIX_LD_LIBRARY_PATH

                     echo "Java Dev Environment Ready!"
          '';
        };
      }
    );
}
