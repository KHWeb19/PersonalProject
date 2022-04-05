<template>
    <v-container>
        <header-view></header-view>
        <br>
        <drop-down></drop-down>
     <div align="center">
        <board-read v-if="board" :board="board"/>
        <p v-else>로딩중 ...... </p>

        <div class="버튼" style="padding:20px;">
            <router-link style="text-decoration: none; color:black" 
            :to="{ name: 'BoardModifyPage', params: { boardNo } }">
                <v-btn text color="black" rounded x-large
                        style="padding: 10px; width: 90px;">
                    수정하기
                </v-btn>
            </router-link>


            <v-btn text color="black" rounded x-large
                style="padding: 10px; width: 90px;" 
                @click="onDelete">
                    삭제하기
            </v-btn>

            <br>

            <router-link style="text-decoration: none; color:black"
            :to="{ name: 'BoardListPage' }">
                <v-btn text color="black" rounded x-large
                        style="padding: 10px; width: 90px;">
                목록으로
                </v-btn>
            </router-link>
        </div>
    </div>

    </v-container>
</template>
<script>
//import { mapState, mapActions } from 'vuex'
//import axios from 'axios'
import HeaderView from '@/components/home/headerView.vue'
import DropDown from '@/components/KategoriePage1/DropDown.vue'
export default {
    name:'K1CheckBrandReadPage',
    components:{ 
    HeaderView,
    DropDown,
    /* backend작업시 풀에정
    props: {
        boardNo: {
            type: String,
            required: true
        }   
    },
  components: {
        BoardRead
    },
   
    computed: {
        ...mapState(['board'])
    },
    created () {
        this.fetchBoard(this.boardNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchBoard']),
        onDelete () {
            var result = confirm('삭제 하시겠습니까?')
            if(result) {
                const { boardNo } = this.board
                axios.delete(`http://localhost:7777/vueboard/${boardNo}`)
                        .then(() => {
                            alert('삭제 되었습니다.')
                            this.$router.push({ name: 'BoardListPage' })
                        })
                        .catch(err => {
                            alert(err.response.data.message)
                        })
            }
        }
    }
}

*/
    }
}
</script>