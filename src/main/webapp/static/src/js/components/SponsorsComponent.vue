<template>
    <slick ref="slick" :options="slickOptions" :class="{footer__slider: true}">
        <div v-for="(slide, index) in slides" :class="{footer__slide: true}">
            <a :href="slide.link" v-if="slide.link" target="_blank" rel="noreferrer nofollow">
                <img :src="slide.img" :alt="'sponsor-' + (index + 1)"/>
            </a>


           <img :src="slide.img" :alt="'sponsor-' + (index + 1)" v-else />
        </div>
    </slick>
</template>

<script>
    import Slick from 'vue-slick';

    export default {
        components: { Slick },

        data() {
            return {
                slickOptions: {
                    slidesToShow: 4,
                    dots: false,
                    arrows: false,
                    autoplay: true,
                    autoplaySpeed: 1000,
                    adaptiveHeight: true,
                    speed: 1000
                },
                slides: [
                    {img: '/static/dist/assets/img/sponsors/familyhouse.jpg', link: null},
                    {img: '/static/dist/assets/img/sponsors/tstbat.jpg', link: null},
                    {img: '/static/dist/assets/img/sponsors/consilium.png', link: "https://www.consilium-gst.be/"},
                    {img: '/static/dist/assets/img/sponsors/puilaetcodewaay.jpg', link: 'https://www.puilaetcodewaay.be/fr'},
                    {img: '/static/dist/assets/img/sponsors/cossup.png', link: 'http://cossup.be/'},
                    {img: '/static/dist/assets/img/sponsors/rodolphecruysmans.png', link: null},
                    {img: '/static/dist/assets/img/sponsors/puttinggolfstudio.jpg', link: "http://www.puttinggolfstudio.com/"},
                    {img: '/static/dist/assets/img/sponsors/bedimo.jpg', link: "http://www.bedimo.com/accueil/"},
                    {img: '/static/dist/assets/img/sponsors/maxelassurance.jpg', link: "http://maxelassurance.be/"},
                    {img: '/static/dist/assets/img/sponsors/pro1gold.png', link: "http://www.pro1golf.com/"},
                    {img: '/static/dist/assets/img/sponsors/mrbricolage.png', link: "https://www.mr-bricolage.be/"},
                    {img: '/static/dist/assets/img/sponsors/madeinlouise.gif', link: "https://www.madeinlouise.com/"},
                    {img: '/static/dist/assets/img/sponsors/dbo.jpeg', link: null},
                    {img: '/static/dist/assets/img/sponsors/dlcw.png', link: "http://www.dlcw.be"},
                    {img: '/static/dist/assets/img/sponsors/natsrawline.png', link: "http://www.natsrawline.com/fr/"},
                    {img: '/static/dist/assets/img/sponsors/scrily.png', link: "https://www.scrily.be"},
                ]
            };
        },

        created() {

        },

        watch: {
            slides: function (newSlides) {
                let currIndex = this.$refs.slick.currentSlide()

                this.$refs.slick.destroy()

                this.$nextTick(() => {
                    this.$refs.slick.create()
                    this.$refs.slick.goTo(currIndex, true)
                })
            }
        },
    }
</script>