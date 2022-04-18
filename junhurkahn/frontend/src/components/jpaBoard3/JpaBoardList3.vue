<template>
    <div>
        <h3>생일관리</h3>
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
      <th scope="col">이름</th>
      <th scope="col">생년월일</th>
      <th scope="col">메모</th>
      <th scope="col">등록날자</th>
            </tr>
            <tr v-if="!jpaBoards3 || (Array.isArray(jpaBoards3) && jpaBoards3.length === 0)">
                <td colspan="5">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="board in jpaBoards3" :key="board.boardNo">
                <td align="center">
                    {{ board.boardNo }}
                </td>
                <td align="center">
                    <router-link :to="{ name: 'JpaBoardReadPage3',
                                        params: { boardNo: board.boardNo.toString() } }">
                        {{ board.title }}
                    </router-link>
                </td>
                <td align="center">
                    {{ board.writer }}
                 </td>
                <td align="center">
                    {{ board.content }}
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
  
    name: 'JpaBoardList3',
    props: {
      jpaBoards3: {
            type: Array,
             required: true
        }
    },

      computed: {
        ...mapState(['jpaBoard3'])
       },

          methods: {
        ...mapActions([
            'fetchJpaBoard3',
            'fetchJpaBoardList3']),
        onDelete (board) {
            const { boardNo } = board;
            //alert('지우는 게시물 번호: ' + boardNo)
            axios.delete(`http://localhost:7777/62th/board3/${boardNo}`)
            .then(() => {
                alert('삭제 성공!')
                this.fetchJpaBoardList3();
                this.$refs.keyword.value = '';
            })
            .catch(() => {
                alert('삭제 실패! 문제 발생!')
            })
        },

        findSearch() {
            const keyword = this.$refs.keyword.value;
            this.fetchJpaBoardList3(keyword);
        }
    }
   
}
</script>