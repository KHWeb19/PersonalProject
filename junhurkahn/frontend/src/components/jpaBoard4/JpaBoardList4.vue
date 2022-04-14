<template>
    <div>
        <h3>사이트아이디 관리</h3>
                      <div class="input-group mb-3">
  <span class="input-group-text" id="inputGroup-sizing-default">Find</span>
  <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
</div>
       <table class="table">
           <tr align="center">
                <th scope="col">번호</th>
      <th scope="col">사이트이름</th>
      <th scope="col">사이트 주소</th>
      <th scope="col">사이트 아이디</th>
      <th scope="col">등록날짜</th>
            </tr>
            <tr v-if="!jpaBoards4 || (Array.isArray(jpaBoards4) && jpaBoards4.length === 0)">
                <td colspan="5">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="board in jpaBoards4" :key="board.boardNo">
                <td align="center">
                    {{ board.boardNo }}
                </td>
                <td align="center">
                    <router-link :to="{ name: 'JpaBoardReadPage4',
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
  
    name: 'JpaBoardList4',
    props: {
      jpaBoards4: {
            type: Array,
             required: true
        }
    },

      computed: {
        ...mapState(['jpaBoard4'])
       },

        methods: {
        ...mapActions([
            'fetchJpaBoard4',
            'fetchJpaBoardList4']),
        onDelete (board) {
            const { boardNo } = board;
            //alert('지우는 게시물 번호: ' + boardNo)
            axios.delete(`http://localhost:7777/62th/board4/${boardNo}`)
            .then(() => {
                alert('삭제 성공!')
                this.fetchJpaBoardList4();
            })
            .catch(() => {
                alert('삭제 실패! 문제 발생!')
            })
        }
        },

        findSearch() {
            const keyword = this.$refs.keyword.value;
            this.fetchJpaBoardList4(keyword);
        }
    }
</script>