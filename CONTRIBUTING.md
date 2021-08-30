# Contribution guide

This project has adopted the [Collective Code Construction Contract
(C4.2)](https://rfc.zeromq.org/spec:42) for contributing. Please read it
before sending patches.

Everyone is expected to follow the
[Scala Code of Conduct](http://www.scala-lang.org/conduct.html) when
discussing the project on the available communication channels.
If you are being harassed, please contact us immediately so that we can
support you.

## Additions to C4.2

1. This project uses the MIT license (see [LICENSE](LICENSE)).
2. The project SHALL have one branch ("main") that always holds the latest 
in-progress version and SHOULD always build.
4. Contributors are listed in the file [AUTHORS.md](AUTHORS.md). Add
yourself if you have contributed.
4. Please maintain the existing code style and try to keep your commits 
small and focused. The `scalafmt` tool SHALL be used to format the code
according to the code style definition in the `.scalafmt.conf` file.
5. Please rebase your branch if the project diverges from your branch.
6. Before a pull request is merged the commits done on the feature branch
SHOULD be squashed into a single commit.
7. Changes are documented in the file [CHANGELOG.md](CHANGELOG.md). Please
use the section `Unreleased` to note your changes.

## Release guide

The changes in the section `Unreleased` in the [CHANGELOG.md](CHANGELOG.md)
file MUST be moved to a section named after the release and a new empty
`Unreleased` section MUST be created.

A release SHALL be accompanied by an annotated tag (`git tag -a NAME`) that
holds a description of the changes that are included in the release. This
description SHOULD be same as in the file [CHANGELOG.md](CHANGELOG.md).

