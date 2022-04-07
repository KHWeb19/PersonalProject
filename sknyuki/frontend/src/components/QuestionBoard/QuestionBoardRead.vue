<template>
   <div class="글작성">
        <h3 style="padding:30px 0px 30px 0px; font-weight:bold" align="left">YOUMUSTHEAR1001</h3>

                <!-- <input type="text" :value="board.boardNo" readonly> -->

                
                <h6 align="left">등록일자 : </h6>
                <b-form-input type="text" :value="board.regDate" readonly>
                </b-form-input>

                <br>

                <h6 align="left">제목 : </h6>
                <b-form-input type="text" :value="board.title" readonly>
                </b-form-input>
            
                <br>

                <h6 align="left">작성자 : </h6>
                <b-form-input type="text" :value="board.writer" readonly>
                </b-form-input>

                <br>

                <h6 align="left">내용 : </h6>
                <b-form-textarea
                    id="textarea-rows"
                    placeholder=""
                    rows="8" :value="board.content" readonly>
                </b-form-textarea>
    </div>
</template>
<script>
export default {
    name:'QuestionBoardRead',
    props: {
        board: {
            type: Object,
            required: true
        }
    }    
}
</script>
<style scoped>
.글작성 {
  padding:0px 200px 0px 200px;
}
</style>