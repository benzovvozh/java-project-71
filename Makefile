run-dist:
	make -C run-dist

build:
	make -C app build

clean:
	make -C app clean

test:
	make -C app test

report:
	make -C app report

lint:
	make -C app lint

.PHONY: build