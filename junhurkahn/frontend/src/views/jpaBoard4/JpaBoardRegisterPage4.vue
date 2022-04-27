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

    <div align="center">
        <br>
       <h1 class="font-weight-bold text-h4 basil--text"  >
       사이트 아이디 등록
      </h1>
      <br>
        <jpa-board-register-form-4 @submit="onSubmit"/>
    </div>
</div>


   <v-footer app color="#FFFBE6" class="white--text">
      <v-spacer></v-spacer>
      <span>&copy; EDDI</span>
    </v-footer>
</div>
</template>

<script>
import JpaBoardRegisterForm4 from '@/components/jpaBoard4/JpaBoardRegisterForm4.vue'
import axios from 'axios'

export default {
    name: 'BoardRegisterPage4',
    components: {
        JpaBoardRegisterForm4
    },
    methods: {
        onSubmit (payload) {
            const { title, content, writer,  writer1 } = payload
            axios.post('http://localhost:7777/62th/board4/register4', { title, writer,writer1, content })
                    .then(() => {
                       
                        this.$router.push({
                            name: 'JpaBoardListPage4'
                        })
                    })
                    .catch(() => {
                       
                    })
        }
    }
}
</script>