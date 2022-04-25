<template>
<div>

    <look-business-member-form/>

</div>    
</template>

<script>

import LookBusinessMemberForm from '@/components/findStore/LookBusinessMemberForm.vue'

export default {
    name: 'storeBoardListPage',
    components:{
        LookBusinessMemberForm
    },
    data() {
        return {
            keyWord: ''
        }
    }

}
</script>

<style scoped>

</style>