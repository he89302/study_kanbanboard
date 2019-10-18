package tw.teddysoft.clean.usecase.kanbanboard.stage.get.impl;

import tw.teddysoft.clean.domain.model.kanbanboard.board.Board;
import tw.teddysoft.clean.domain.model.kanbanboard.stage.Stage;
import tw.teddysoft.clean.usecase.kanbanboard.board.BoardRepository;
import tw.teddysoft.clean.usecase.kanbanboard.stage.StageRepository;
import tw.teddysoft.clean.usecase.kanbanboard.stage.get.DtoConvertor;
import tw.teddysoft.clean.usecase.kanbanboard.stage.get.GetStageInput;
import tw.teddysoft.clean.usecase.kanbanboard.stage.get.GetStageOutput;
import tw.teddysoft.clean.usecase.kanbanboard.stage.get.GetStageUseCase;

import java.util.List;

public class GetStageUseCaseImpl implements GetStageUseCase {

    private BoardRepository boardRepository;
    private StageRepository stageRepository;

    public GetStageUseCaseImpl(BoardRepository boardRepository,
                               StageRepository stageRepository) {
        this.boardRepository = boardRepository;
        this.stageRepository = stageRepository;
    }

    public void execute(GetStageInput input, GetStageOutput output) {

        List<Stage> stages;
        if (input.isFindAll()){
            stages = stageRepository.findAll();
        }
        else{
            stages = stageRepository.findByBoardId(input.getBoardId());
        }

        output.setStageDtos(DtoConvertor.createStageDtoList(stages, boardRepository));
    }

    public static GetStageInput createInput(){
        return new GetStageInputImpl();
    }

    private static class GetStageInputImpl implements GetStageInput{
        private String boardId;
        private boolean isFindAll = false;

        public String getBoardId() {
            return boardId;
        }

        @Override
        public void setFindAll(boolean arg) {
            isFindAll = arg;
        }

        @Override
        public boolean isFindAll() {
            return isFindAll;
        }

        public void setBoardId(String boardId) {
            this.boardId = boardId;
        }
    }
}
