<template>

    <div>
        <h3>계좌번호 목록</h3>
    <div class="input-group mb-3">
  
  <span class="input-group-text" id="inputGroup-sizing-default" @click="findSearch">Find</span>

  <input type="text" 
        class="form-control" 
        ref="keyword"
        aria-label="Sizing example input" 
        aria-describedby="inputGroup-sizing-default">

</div>
        <table class="table">
            
           <tr align="center">
                
      <th scope="col">번호</th>
      <th scope="col">은행명</th>
      <th scope="col">계좌번호</th>
      <th scope="col">소유자이름</th>
      <th scope="col">날짜</th>
            </tr>
            <tr v-if="!jpaBoards1 || (Array.isArray(jpaBoards1) && jpaBoards1.length === 0)">
                <td colspan="5">
                    현재 등록된 게시물이 없습니다! 
                </td>
            </tr>
            <tr v-else v-for="board in jpaBoards1" :key="board.boardNo">
                <td align="center">
                    {{ board.boardNo }} 
                </td>
                <td align="center">
                    <router-link :to="{ name: 'JpaBoardReadPage1',
                                        params: { boardNo: board.boardNo.toString() } }">
                        {{ board.title }}
                    </router-link>
                </td>
                <td align="center">
                    {{ board.writer }}
                </td>

                 <td align="center">
                    {{ board.writer1 }}
                </td>


                <td align="center">
                    {{ board.regDate }}  
                  
                    <button type="button" class="btn btn-danger" @click="onDelete(board)">Delete</button>
                    
                </td>
            </tr>
        </table>
    </div>

</template>

<script>

import axios from 'axios'
import { mapActions,mapState} from 'vuex'


export default {
 
    name: 'JpaBoardList1',
    props: {
      jpaBoards1: {
            
            type: Array,
             required: true
        }
    },
       computed: {
        ...mapState(['jpaBoard1'])
       },

     

     methods: {
        ...mapActions([
            'fetchJpaBoard1',
            'fetchJpaBoardList1']),
        onDelete (board) {
            const { boardNo } = board;
            //alert('지우는 게시물 번호: ' + boardNo)
            axios.delete(`http://localhost:7777/62th/board1/${boardNo}`)
            .then(() => {
                alert('삭제 성공!')
                this.fetchJpaBoardList1();
                this.$refs.keyword.value = '';
            })
            .catch(() => {
                alert('삭제 실패! 문제 발생!')
            })
        },

        findSearch() {
            const keyword = this.$refs.keyword.value;
            this.fetchJpaBoardList1(keyword);
        }
    }
   
}
    



</script>