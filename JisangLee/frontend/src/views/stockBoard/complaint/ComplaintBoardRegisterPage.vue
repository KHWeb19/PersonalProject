<template>
<div align="center">
        <br><br>
        <span id="shadow" class="shadow">하소연</span>
        <br><br>
        <complaint-board-register-form @submit="onSubmit"/>
</div>
</template>

<script>
import swal from 'sweetalert';
import ComplaintBoardRegisterForm from '@/components/stockBoard/complaint/ComplaintBoardRegisterForm.vue'
import axios from 'axios'

export default {
    name: 'ComplaintBoardRegisterPage',
    components: {
        ComplaintBoardRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { title, content, writer } = payload
            axios.post('http://localhost:7777/complaintboard/register', { title, writer, content })
                    .then(() => {
                        swal({                                                                              
                            text: "게시물이 등록되었습니다!",
                            icon: "success"
                            })
                            
                        this.$router.push({
                            name: 'ComplaintBoardListPage'
                        })
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }
    }
}
</script>