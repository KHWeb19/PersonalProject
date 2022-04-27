<template>


<div class="p-3 mb-2 bg-light text-dark">
<div>
  <v-card color="basil">
    <v-card-title class="text-center justify-center py-6">
      <h1 class="font-weight-bold text-h2 basil--text"  >
       Note
      </h1>
    </v-card-title>

    <v-tabs
      v-model="tab"
      background-color="transparent"
      color="basil"
      grow
    >
      <v-tab
      >
      </v-tab>
    </v-tabs>
  </v-card>
</div>

    <div align="center">
        <br>
       <h1 class="font-weight-bold text-h4 basil--text"  >
       사이트 아이디 수정
      </h1>
      <br>
        <jpa-board-modify-form-4  v-if="jpaBoard4" :jpaBoard4="jpaBoard4" @submit="onSubmit"/>
        <p v-else>로딩중 .......</p>
    
</div>

   <v-footer app color="#FFFBE6" class="white--text">
      <v-spacer></v-spacer>
      <span>&copy; EDDI</span>
    </v-footer>
    
</div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import JpaBoardModifyForm4 from '@/components/jpaBoard4/JpaBoardModifyForm4.vue'
export default {
    name: 'JpaBoardModifyPage4',
    components: {
        JpaBoardModifyForm4
    },
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['jpaBoard4'])
    },
    methods: {
        ...mapActions(['fetchJpaBoard4']),
        onSubmit (payload) {
            const { title, content,writer,writer1 } = payload
            axios.put(`http://localhost:7777/62th/board4/${this.boardNo}`,
                { title, writer,  writer1, content, regDate: this.jpaBoard4.regDate })
                    .then(res => {
                        alert('게시물 수정 성공!')
                        this.$router.push({
                            name: 'JpaBoardReadPage4',
                            params: { boardNo: res.data.boardNo.toString()}
                        })
                    })
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })
        }
    },
    created () {
        this.fetchJpaBoard4(this.boardNo)
                .catch(() => {
                    alert('게시물 DB 조회 실패!')
                    this.$router.back()
                })
    }
}
</script>