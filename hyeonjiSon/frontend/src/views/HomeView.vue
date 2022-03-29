<template>
  <hello-world />
</template>

<script>
  import HelloWorld from '../components/HelloWorld'

  export default {
    name: 'Home',

    components: {
      HelloWorld,
    },
  }
  /*
  export default {

name: 'Discount-a'

}

이런식으로 '-' 이용해서 여러단어로 구성해주거나

export default {

//eslint-disable-next-line

name: 'Discount'

}

이렇게 위해 주석 추가해주면 됩니다.
  */
</script>
