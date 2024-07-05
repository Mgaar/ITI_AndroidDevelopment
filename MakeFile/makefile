
cc = gcc
ProgramName=calculator.out
INCS = -I./include
SRC = ./src/
obj=./bin/
exe=./build/


sourcfiles = $(wildcard $(SRC)*.c)

objectfiles = $(patsubst $(SRC)%.c,$(obj)%.o,$(sourcfiles))

all : $(ProgramName)

$(obj)%.o:$(SRC)%.c
	$(cc) $(INCS) -c $< -o $@
	
$(ProgramName):$(objectfiles)
	$(cc) $(INCS) $(objectfiles) -o $(exe)$(ProgramName)
.PHONY:clean	
clean:
	rm $(obj)*.o $(exe)*.out


	
