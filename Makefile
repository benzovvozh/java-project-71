build:
	make -C app build
checkstyleMain:
	make -C app lint
report:
	make -C app report
test:
	make -C app test