FROM mcr.microsoft.com/devcontainers/java:dev-17 AS BUILDER
ADD --checksum=sha256:7a9cdf674fc1703d6382f5f330b3d110ea1b512b51f1652846d9e4e8a588d766 \
    https://dlcdn.apache.org/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.tar.gz \
    /tmp/apache-maven-3.9.9-bin.tar.gz
RUN tar -xvf /tmp/apache-maven-3.9.9-bin.tar.gz -C /tmp/
FROM mcr.microsoft.com/devcontainers/java:dev-17
COPY --from=BUILDER /tmp/apache-maven-3.9.9 /opt/maven
ENV PATH="$PATH:/opt/maven/bin"