<template>


    <div>
        <h3>게시물 목록</h3>
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
               <th scope="col">제목</th>
               <th scope="col">작성자</th>
               <th scope="col">등록일자</th>
            </tr>
            <tr v-if="!jpaBoards || (Array.isArray(jpaBoards) && jpaBoards.length === 0)">
                <td colspan="4">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="board in jpaBoards" :key="board.boardNo">
                <td align="center">
                    {{ board.boardNo }} 
                </td>
                <td align="center">
                    <router-link :to="{ name: 'JpaBoardReadPage',
                                        params: { boardNo: board.boardNo.toString() } }">
                        {{ board.title }}
                    </router-link>
                </td>
                <td align="center">
                    {{ board.writer }}
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
  
    name: 'JpaBoardList',
    props: {
      jpaBoards: {
            type: Array,
             required: true
        }
    },

      computed: {
        ...mapState(['jpaBoard'])
       },

         methods: {
        ...mapActions([
            'fetchJpaBoard',
            'fetchJpaBoardList']),
        onDelete (board) {
            const { boardNo } = board;
            //alert('지우는 게시물 번호: ' + boardNo)
            axios.delete(`http://localhost:7777/62th/board/${boardNo}`)
            .then(() => {
                alert('삭제 성공!')
                this.fetchJpaBoardList();
                this.$refs.keyword.value = '';
            })
            .catch(() => {
                alert('삭제 실패! 문제 발생!')
            })
        },

        findSearch() {
            const keyword = this.$refs.keyword.value;
            this.fetchJpaBoardList(keyword);
        }
    }
   
}




    


</script>
